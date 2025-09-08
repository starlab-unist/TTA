function Strongest_Extension(class_name, extensions) {
    let strong = extensions[0];
    let my_val = Array.from(extensions[0]).filter(x => x >= 'A' && x <= 'Z').length -
                 Array.from(extensions[0]).filter(x => x >= 'a' && x <= 'z').length;
    
    for (let s of extensions) {
        let val = Array.from(s).filter(x => x >= 'A' && x <= 'Z').length -
                  Array.from(s).filter(x => x >= 'a' && x <= 'z').length;
        
        if (val > my_val) {
            strong = s;
            my_val = val;
        }
    }

    let ans = class_name + "." + strong;
    return ans;
}