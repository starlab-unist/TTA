test_cases = [
    (["hello", "world", "hello world"], "hello"),
    (["abc", "def", "xyz"], "a"),
    (["123", "456", "789"], "1"),
    (["", "a", "b"], "a"),
    (["apple", "banana", "cherry"], "an"),
    (["test", "text", "taste"], "t"),
    (["UPPER", "lower", "Mixed"], "lower"),
    (["empty", "list", "without match"], "xyz"),
    (["a", "aa", "aaa"], "a"),
    (["Case", "case", "CASE"], "case")
]