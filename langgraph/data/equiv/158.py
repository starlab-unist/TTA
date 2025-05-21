def determine_longest_unique_char_string(word_list):
    def custom_sort_key(word):
        return (-len(set(word)), word)
    
    sorted_words = sorted(word_list, key=custom_sort_key)
    return sorted_words[0]

# method name: find_max -> determine_longest_unique_char_string
# parameter name: words -> word_list
# replaced lambda with a named function custom_sort_key for clarity
# separated the sorting step into its own line for better readability