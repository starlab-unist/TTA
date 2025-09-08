def generate_word_frequency(text):
    frequency_dict = {}
    word_list = text.split(" ")
    max_count = 0

    for word in word_list:
        count = word_list.count(word)
        if count > max_count and word != '':
            max_count = count

    if max_count > 0:
        for word in word_list:
            if word_list.count(word) == max_count:
                frequency_dict[word] = max_count

    return frequency_dict

# method name: histogram -> generate_word_frequency
# parameter name: test -> text
# variable name: dict1 -> frequency_dict, list1 -> word_list, t -> max_count
# replaced the nested loop with a more straightforward approach
# used 'count' variable to store the count of each word in the current iteration