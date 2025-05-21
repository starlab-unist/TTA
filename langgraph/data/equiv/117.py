def filter_words_by_consonant_count(input_string, target_consonant_count):
    selected_words = []
    words = input_string.split()

    for word in words:
        consonant_counter = 0
        index = 0
        while index < len(word):
            if word[index].lower() not in "aeiou":
                consonant_counter += 1
            index += 1

        if consonant_counter == target_consonant_count:
            selected_words.append(word)

    return selected_words

# method name: select_words -> filter_words_by_consonant_count
# parameter name: s -> input_string, n -> target_consonant_count
# variable name: result -> selected_words, word -> word, n_consonants -> consonant_counter
# changed for loop to while loop for counting consonants
# used string literal "aeiou" instead of list for vowel check