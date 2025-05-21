def skjkasdkd(lst):
    def isPrime(n):
        for i in range(2,int(n**0.5)+1):
            if n%i==0:
                return False

        return True
    maxx = 0
    i = 0
    while i < len(lst):
        if(lst[i] > maxx and isPrime(lst[i])):
            maxx = lst[i]
        i+=1
    result = sum(int(digit) for digit in str(maxx))
    return result

def find_largest_prime_digit_sum(numbers):
    def check_prime(number):
        for divisor in range(2, int(number**0.5) + 1):
            if number % divisor == 0:
                return False
        return True

    largest_prime = 0
    index = 0
    while index < len(numbers):
        if numbers[index] > largest_prime and check_prime(numbers[index]):
            largest_prime = numbers[index]
        index += 1

    digit_sum = sum(int(char) for char in str(largest_prime))
    return digit_sum


import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        [3, 5, 7, 2, 8],          # Simple list with primes
        [10, 15, 21, 22],         # No prime numbers
        [29, 31, 37, 41],         # All prime numbers
        [1, 4, 6, 8, 9],          # Only one prime (2)
        [0, -3, -5, -7],          # Negative and zero values
        [11, 13, 17, 19, 23, 29], # Larger primes
        [2, 3, 5, 7, 11, 13],     # Small consecutive primes
        [41, 37, 31, 29, 23],     # Descending order of primes
        [89, 97, 101, 103],       # Primes greater than 80
        [59, 61, 67, 71, 73]      # Another set of consecutive primes
    ]

    def test_0(self):
        self.assertEqual(skjkasdkd(self.test_cases[0]), find_largest_prime_digit_sum(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(skjkasdkd(self.test_cases[1]), find_largest_prime_digit_sum(self.test_cases[1]))

    def test_2(self):
        self.assertEqual(skjkasdkd(self.test_cases[2]), find_largest_prime_digit_sum(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(skjkasdkd(self.test_cases[3]), find_largest_prime_digit_sum(self.test_cases[3]))

    def test_4(self):
        self.assertEqual(skjkasdkd(self.test_cases[4]), find_largest_prime_digit_sum(self.test_cases[4]))
    
    def test_5(self):
        self.assertEqual(skjkasdkd(self.test_cases[5]), find_largest_prime_digit_sum(self.test_cases[5]))

    def test_6(self):
        self.assertEqual(skjkasdkd(self.test_cases[6]), find_largest_prime_digit_sum(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(skjkasdkd(self.test_cases[7]), find_largest_prime_digit_sum(self.test_cases[7]))

    def test_8(self):
        self.assertEqual(skjkasdkd(self.test_cases[8]), find_largest_prime_digit_sum(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(skjkasdkd(self.test_cases[9]), find_largest_prime_digit_sum(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()