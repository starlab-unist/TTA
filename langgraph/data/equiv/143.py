def filter_unique_length_words(phrase):
    result = []
    for term in phrase.split():
        flag = False
        if len(term) == 1:
            flag = True
        divisor = 2
        while divisor < len(term):
            if len(term) % divisor == 0:
                flag = True
                break
            divisor += 1
        if not flag or len(term) == 2:
            result.append(term)
    return " ".join(result)

# method name: words_in_sentence -> filter_unique_length_words
# parameter name: sentence -> phrase
# variable name: new_lst -> result, flg -> flag
# replaced for loop with while loop for divisor checking
# used break to exit the loop early when a divisor is found
# changed the condition to check flag with not flag for clarity