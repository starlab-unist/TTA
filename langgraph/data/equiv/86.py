def order_words_characters(input_string):
    result = []
    for word in input_string.split(' '):
        sorted_word = ''.join(sorted(word))
        result.append(sorted_word)
    return ' '.join(result)

# method name: anti_shuffle -> order_words_characters
# parameter name: s -> input_string
# replaced list comprehension with a for loop for clarity
# variable name: i -> word, sorted(list(i)) -> sorted_word
# used append method to build the result list