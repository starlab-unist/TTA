def order_words_in_string(input_string):
    result = []
    for word in input_string.split(' '):
        sorted_characters = ''.join(sorted(word))
        result.append(sorted_characters)
    return ' '.join(result)

# method name: anti_shuffle -> order_words_in_string
# parameter name: s -> input_string
# replaced list comprehension with a for loop for clarity
# changed variable name: i -> word, sorted(list(i)) -> sorted_characters
# used append to build the result list explicitly