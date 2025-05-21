def get_max_triples(n):
    A = [i*i - i + 1 for i in range(1,n+1)]
    ans = []
    for i in range(n):
        for j in range(i+1,n):
            for k in range(j+1,n):
                if (A[i]+A[j]+A[k])%3 == 0:
                    ans += [(A[i],A[j],A[k])]
    return len(ans)

def count_divisible_triples(limit):
    sequence = [x*x - x + 1 for x in range(1, limit+1)]
    result_count = 0
    
    index_i = 0
    while index_i < limit:
        index_j = index_i + 1
        while index_j < limit:
            index_k = index_j + 1
            while index_k < limit:
                if (sequence[index_i] + sequence[index_j] + sequence[index_k]) % 3 == 0:
                    result_count += 1
                index_k += 1
            index_j += 1
        index_i += 1
    
    return result_count

import unittest

# Test Cases
class TestFunctionEquivalence(unittest.TestCase):

    test_cases = [
        1,  # No triples possible
        2,  # No triples possible
        3,  # One triple (1, 3, 7)
        4,  # Two triples (1, 7, 19), (3, 7, 13)
        5,  # Four triples (1, 7, 31), (1, 13, 21), (3, 7, 31), (3, 13, 19)
        6,  # Six triples
        7,  # Ten triples
        8,  # Fourteen triples
        9,  # Twenty-one triples
        10  # Thirty-one triples
    ]

    def test_0(self):
        self.assertEqual(get_max_triples(self.test_cases[0]), count_divisible_triples(self.test_cases[0]))
    
    def test_1(self):
        self.assertEqual(get_max_triples(self.test_cases[1]), count_divisible_triples(self.test_cases[1]))
        
    def test_2(self):
        self.assertEqual(get_max_triples(self.test_cases[2]), count_divisible_triples(self.test_cases[2]))
    
    def test_3(self):
        self.assertEqual(get_max_triples(self.test_cases[3]), count_divisible_triples(self.test_cases[3]))
    
    def test_4(self):
        self.assertEqual(get_max_triples(self.test_cases[4]), count_divisible_triples(self.test_cases[4]))
        
    def test_5(self):
        self.assertEqual(get_max_triples(self.test_cases[5]), count_divisible_triples(self.test_cases[5]))
    
    def test_6(self):
        self.assertEqual(get_max_triples(self.test_cases[6]), count_divisible_triples(self.test_cases[6]))
    
    def test_7(self):
        self.assertEqual(get_max_triples(self.test_cases[7]), count_divisible_triples(self.test_cases[7]))
    
    def test_8(self):
        self.assertEqual(get_max_triples(self.test_cases[8]), count_divisible_triples(self.test_cases[8]))
    
    def test_9(self):
        self.assertEqual(get_max_triples(self.test_cases[9]), count_divisible_triples(self.test_cases[9]))

if __name__ == '__main__':
    unittest.main()