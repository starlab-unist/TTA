def process_text(input_string):
    if not input_string:
        return []

    processed_chars = []

    index = 0
    while index < len(input_string):
        char = input_string[index]
        if char == ',':
            processed_chars.append(' ')
        else:
            processed_chars.append(char)
        index += 1

    processed_string = ''.join(processed_chars)
    return processed_string.split()

# method name: words_string -> process_text
# parameter name: s -> input_string
# variable name: s_list -> processed_chars
# changed for loop to while loop with index
# kept the logic of replacing ',' with ' '
# joined list to string and split to words