def count_even_odd_palindromes(limit):
    def check_palindrome(number):
        return str(number) == ''.join(reversed(str(number)))

    count_even_palindromes = 0
    count_odd_palindromes = 0

    current_number = 1
    while current_number <= limit:
        if current_number % 2 != 0 and check_palindrome(current_number):
            count_odd_palindromes += 1
        elif current_number % 2 == 0 and check_palindrome(current_number):
            count_even_palindromes += 1
        current_number += 1

    return (count_even_palindromes, count_odd_palindromes)

# method name: even_odd_palindrome -> count_even_odd_palindromes
# parameter name: n -> limit
# inner function name: is_palindrome -> check_palindrome
# replaced for loop with while loop
# changed condition i%2 == 1 to i%2 != 0 for checking odd numbers
# used reversed() function instead of slicing for palindrome check
# renamed variables: even_palindrome_count -> count_even_palindromes, odd_palindrome_count -> count_odd_palindromes