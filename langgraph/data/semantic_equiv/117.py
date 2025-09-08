def filter_words_by_consonant_count(text, target_consonants):
    words = text.split()
    selected_words = []

    index = 0
    while index < len(words):
        current_word = words[index]
        consonant_count = 0
        for char in current_word:
            if char.lower() not in 'aeiou':
                consonant_count += 1
        if consonant_count == target_consonants:
            selected_words.append(current_word)
        index += 1

    return selected_words

# method name: select_words -> filter_words_by_consonant_count
# parameter name: s -> text, n -> target_consonants
# variable name: result -> selected_words
# changed for loop to while loop
# simplified the check for vowels using 'not in' with a string instead of a list
# used a more explicit increment for the while loop index