def validate_file_identifier(filename):
    valid_extensions = ['txt', 'exe', 'dll']
    parts = filename.rsplit('.', 1)
    
    if len(parts) != 2:
        return 'No'
    
    extension, name = parts
    if extension not in valid_extensions:
        return 'No'
    
    if not name:
        return 'No'
    
    if not name[0].isalpha():
        return 'No'
    
    digit_count = sum(c.isdigit() for c in name)
    if digit_count > 3:
        return 'No'
    
    return 'Yes'

# method name: file_name_check -> validate_file_identifier
# parameter name: file_name -> filename
# variable name: suf -> valid_extensions, lst -> parts
# replaced split with rsplit and specified maxsplit to 1
# unpacked parts into extension and name for clarity
# used sum with generator expression for digit count instead of list comprehension