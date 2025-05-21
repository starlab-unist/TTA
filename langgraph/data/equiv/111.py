def generate_frequency_map(input_string):
    frequency_dict = {}
    word_list = input_string.split()
    max_count = 0

    for word in word_list:
        current_count = word_list.count(word)
        if current_count > max_count and word != '':
            max_count = current_count

    if max_count > 0:
        for word in word_list:
            if word_list.count(word) == max_count:
                frequency_dict[word] = max_count

    return frequency_dict

# method name: histogram -> generate_frequency_map
# parameter name: test -> input_string
# variable name: dict1 -> frequency_dict, list1 -> word_list, t -> max_count
# replaced the initial check for non-empty string with a condition inside the loop
# used a separate variable `current_count` to store the count of each word
# maintained the logic of finding the maximum occurrence and building the dictionary