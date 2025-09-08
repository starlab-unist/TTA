def check_prime_in_overlap(range_a, range_b):
    def prime_check(number):
        if number < 2:
            return False
        if number == 2:
            return True
        for divisor in range(2, number):
            if number % divisor == 0:
                return False
        return True

    start = max(range_a[0], range_b[0])
    end = min(range_a[1], range_b[1])
    overlap_length = end - start
    if overlap_length > 0 and prime_check(overlap_length):
        return "YES"
    return "NO"

# method name: intersection -> check_prime_in_overlap
# parameter names: interval1 -> range_a, interval2 -> range_b
# variable names: l -> start, r -> end, length -> overlap_length
# renamed inner function: is_prime -> prime_check
# kept the logic and structure similar but changed identifiers and added comments for clarity