function Strongest_Extension(class_name, extensions) {
    let strong = extensions[0];
    let my_val = (strong.match(/[A-Z]/g) || []).length - (strong.match(/[a-z]/g) || []).length;
    
    for (let s of extensions) {
        let val = (s.match(/[A-Z]/g) || []).length - (s.match(/[a-z]/g) || []).length;
        if (val > my_val) {
            strong = s;
            my_val = val;
        }
    }

    let ans = class_name + "." + strong;
    return ans;
}