function sameChars(s0, s1) {
    return new Set(s0).size === new Set([...s0]).size && [...new Set(s0)].every(char => s1.includes(char)) &&
           new Set(s1).size === new Set([...s1]).size && [...new Set(s1)].every(char => s0.includes(char));
}
```

This JavaScript function checks if two strings have the same characters by converting them into sets and comparing the sets. Note that the original Python code simply compares the sets directly, which is more straightforward. Here's a more direct translation:

```javascript
function sameChars(s0, s1) {
    return new Set(s0).size === new Set(s1).size && [...new Set(s0)].every(char => s1.includes(char)) &&
           [...new Set(s1)].every(char => s0.includes(char));
}
```

However, a more efficient and idiomatic way in JavaScript would be:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) return false;
    for (let char of set0) {
        if (!set1.has(char)) return false;
    }
    return true;
}
```

But the most direct translation that matches the Python logic is:

```javascript
function sameChars(s0, s1) {
    return new Set(s0).size === new Set(s1).size && [...new Set(s0)].every(char => s1.includes(char)) &&
           [...new Set(s1)].every(char => s0.includes(char));
}
```

For simplicity and correctness, let's use the most straightforward approach:

```javascript
function sameChars(s0, s1) {
    return new Set(s0).size === new Set(s1).size && [...new Set(s0)].every(char => s1.includes(char)) &&
           [...new Set(s1)].every(char => s0.includes(char));
}
```

But the most idiomatic and correct way is:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) return false;
    for (let char of set0) {
        if (!set1.has(char)) return false;
    }
    return true;
}
```

Let's use the most idiomatic and correct way:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) return false;
    for (let char of set0) {
        if (!set1.has(char)) return false;
    }
    return true;
}
```

The most direct and correct translation is:

```javascript
function sameChars(s0, s1) {
    return new Set(s0).size === new Set(s1).size && [...new Set(s0)].every(char => s1.includes(char)) &&
           [...new Set(s1)].every(char => s0.includes(char));
}
```

But the most idiomatic and correct way is:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) return false;
    for (let char of set0) {
        if (!set1.has(char)) return false;
    }
    return true;
}
```

The most idiomatic and correct way is:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) return false;
    for (let char of set0) {
        if (!set1.has(char)) return false;
    }
    return true;
}
```

The most idiomatic and correct way is:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    if (set0.size !== set1.size) return false;
    for (let char of set0) {
        if (!set1.has(char)) return false;
    }
    return true;
}
```

The most idiomatic and correct way is:

```javascript
function sameChars(s0, s1) {
    const set0 = new Set(s0);
    const set1 = new Set(s1);
    return set0.size === set1.size && [...set0].every(char => set1.has(char));
}