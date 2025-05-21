def count_even_odd_palindromes(limit):
    def check_palindrome(number):
        return str(number) == str(number)[::-1]

    even_count = 0
    odd_count = 0

    current_number = 1
    while current_number <= limit:
        if current_number % 2 == 1 and check_palindrome(current_number):
            odd_count += 1
        elif current_number % 2 == 0 and check_palindrome(current_number):
            even_count += 1
        current_number += 1

    return (even_count, odd_count)

# method name: even_odd_palindrome -> count_even_odd_palindromes
# parameter name: n -> limit
# inner function name: is_palindrome -> check_palindrome
# variable names: even_palindrome_count -> even_count, odd_palindrome_count -> odd_count
# replaced for loop with while loop
# used current_number to iterate instead of i