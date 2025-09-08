import re

def count_personal_statements(text):
    sentence_list = re.split(r'[.?!]\s*', text)
    personal_statement_count = 0
    
    for sentence in sentence_list:
        if sentence.startswith('I '):
            personal_statement_count += 1
    
    return personal_statement_count
# method name: is_bored -> count_personal_statements
# parameter name: S -> text
# variable name: sentences -> sentence_list, sum(...) -> personal_statement_count
# replaced list comprehension with a for loop and if condition
# used startswith method for clarity