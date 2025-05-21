def extract_and_count_words(input_text):
    if ' ' in input_text:
        word_list = input_text.split()
    elif ',' in input_text:
        word_list = input_text.replace(',', ' ').split()
    else:
        count = sum(1 for char in input_text if char.islower() and ord(char) % 2 == 0)
        return count

    return word_list

# method name: split_words -> extract_and_count_words
# parameter name: txt -> input_text
# variable name: words -> word_list
# replaced list comprehension with sum for counting lowercase characters with even ASCII values
# used direct return for count instead of wrapping it in a list