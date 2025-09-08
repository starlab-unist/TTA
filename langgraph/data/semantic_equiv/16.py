def determine_unique_char_count(input_text: str) -> int:
    unique_chars = set(input_text.lower())
    return len(unique_chars)

# method name: count_distinct_characters -> determine_unique_char_count
# parameter name: string -> input_text
# variable name: words -> unique_chars
# used set directly in return statement for simplicity