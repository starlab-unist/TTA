
import glob
import subprocess
from tqdm import tqdm
from argparse import ArgumentParser

def parse_args():
    
    parser = ArgumentParser()
    
    parser.add_argument("--test_py_folder", type=str, default="/workspace/vtw/data/test-py")
    parser.add_argument("--test_js_folder", type=str, default="/workspace/vtw/result/qwen/3b-test-js")
    parser.add_argument("-o", "--output_dir", type=str, default="/workspace/vtw/result/qwen/3b-report.txt")
    
    return parser.parse_args()

def main(args):
    
    test_py_folder = args.test_py_folder
    if not test_py_folder.endswith("/"):
        test_py_folder += "/"
        
    test_py = sorted(glob.glob(test_py_folder + "[0-9]*.py"), key=lambda x: int(x.split("/")[-1].split(".")[0]))
    
    test_js_folder = args.test_js_folder
    if not test_js_folder.endswith("/"):
        test_js_folder += "/"
    
    test_js = sorted(glob.glob(test_js_folder + "[0-9]*.test.js"), key=lambda x: int(x.split("/")[-1].split(".")[0]))
    
    assert len(test_py) == len(test_js), "The number of test_py and test_js is not the same!"
    
    report = ["id\tpy\tjs\tnotice"]
    success_samples = []
    failure_samples = []
    abnormal_samples = []
    invalid_samples = []
    
    for i, (t_py, t_js) in enumerate(tqdm(zip(test_py, test_js))):
        
        # if "import unittest" not in open(t_py).read():
        #     content = [line.rstrip("\n") for line in open(t_py).readlines()]
        #     content.insert(0, "import unittest")
        #     with open(t_py, 'w') as f:
        #         f.write("\n".join(content))
        
        try:
            result_py = subprocess.run(
                f"python {t_py}",
                shell=True,
                text=True,
                capture_output=True,
                timeout=5
            )
        except Exception as e:
            result_py = subprocess.CompletedProcess(args=["python"], returncode=1, stdout="", stderr=str(e))
        
        try:
            result_js = subprocess.run(
                f"cd {test_js_folder}; npx jest {t_js}",
                shell=True,
                text=True,
                capture_output=True,
                timeout = 5
            )
        except Exception as e:
            result_js = subprocess.CompletedProcess(args=["npx"], returncode=1, stdout="", stderr=str(e))
        
        r_py = result_py.returncode == 0
        r_js = result_js.returncode == 0
        
        if r_py and r_js:
            notice = "Success"
            success_samples.append(i)
        elif r_py and (not r_js):
            notice = "Failure"
            failure_samples.append(i)
        elif (not r_py) and r_js:
            notice = "Abnormal"
            abnormal_samples.append(i)
        elif (not r_py) and (not r_js):
            notice = "Invalid"
            invalid_samples.append(i)
            
        report.append(f"{i}\t{r_py}\t{r_js}\t{notice}")
    
    total = len(test_py)
    valid_count = total - len(invalid_samples)
    
    valid_log = "valid rate: {} / {} ({} %)".format(
        valid_count, total, (valid_count / total) * 100
    )
    
    print(valid_log)
    report.append(valid_log)
    
    success_log = "success rate: {}/{} ({} %)".format(
        len(success_samples), valid_count, (len(success_samples) / valid_count) * 100
    )
    
    print(success_log)
    report.append(success_log)
    
    abnormal_log = "abnormal cases: {}".format(abnormal_samples)
    
    print(abnormal_log)
    report.append(abnormal_log)
    
    invalid_log = "invalid cases: {}".format(invalid_samples)
    
    print(invalid_log)
    report.append(invalid_log)
    
    with open(args.output_dir, 'w') as f:
        f.write("\n".join(report))

if __name__=="__main__":
    args = parse_args()
    main(args)
