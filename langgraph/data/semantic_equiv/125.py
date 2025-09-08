def partition_text(input_string):
    if ' ' in input_string:
        return input_string.split()
    elif ',' in input_string:
        modified_string = input_string.replace(',', ' ')
        return modified_string.split()
    else:
        lowercase_even_count = sum(1 for char in input_string if char.islower() and ord(char) % 2 == 0)
        return lowercase_even_count

# method name: split_words -> partition_text
# parameter name: txt -> input_string
# replaced list comprehension with sum for counting lowercase even characters
# renamed variable for clarity: counts -> lowercase_even_count