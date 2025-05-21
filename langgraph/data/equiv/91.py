import re

def count_personal_statements(text):
    segments = re.split(r'[.?!]\s*', text)
    personal_statement_count = 0

    for segment in segments:
        if segment.startswith('I '):
            personal_statement_count += 1

    return personal_statement_count
# method name: is_bored -> count_personal_statements
# parameter name: S -> text
# variable name: sentences -> segments, sum(...) -> personal_statement_count
# replaced list comprehension with a for loop and if condition