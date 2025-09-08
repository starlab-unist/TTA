def calculate_string_length(text: str) -> int:
    count = 0
    for character in text:
        count += 1
    return count
# method name: strlen -> calculate_string_length
# parameter name: string -> text
# replaced built-in len() with manual iteration and counting