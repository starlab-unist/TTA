def check_monotonic_sequence(sequence: list):
    ascending = sequence.copy()
    descending = sequence.copy()
    
    ascending.sort()
    descending.sort(reverse=True)
    
    if sequence == ascending or sequence == descending:
        return True
    return False

# method name: monotonic -> check_monotonic_sequence
# parameter name: l -> sequence
# introduced ascending and descending variables for clarity
# used sort() method on copies of the list instead of sorted() function directly
# kept the same logic but changed the implementation style