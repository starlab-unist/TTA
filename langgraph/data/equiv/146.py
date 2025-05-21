def count_special_numbers(numbers):
    
    total = 0
    iterator = iter(numbers)
    
    while True:
        try:
            current_number = next(iterator)
            if current_number > 10:
                odd_digits_set = {1, 3, 5, 7, 9}
                num_str = str(current_number)
                if int(num_str[0]) in odd_digits_set and int(num_str[-1]) in odd_digits_set:
                    total += 1
        except StopIteration:
            break
        
    return total

# method name: specialFilter -> count_special_numbers
# parameter name: nums -> numbers
# variable name: count -> total
# for loop replaced with while loop using iterator and try-except block
# odd_digits tuple replaced with odd_digits_set set for membership test
# used next() to fetch elements from the iterator