function common(l1, l2) {
    const ret = new Set();
    for (const e1 of l1) {
        for (const e2 of l2) {
            if (e1 === e2) {
                ret.add(e1);
            }
        }
    }
    return Array.from(ret).sort();
}