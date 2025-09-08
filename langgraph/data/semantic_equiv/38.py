def transform_string_cyclic(input_string: str):
    """
    Encodes the input string by cyclically rotating groups of three characters.
    """
    # Divide the string into chunks of three characters
    chunks = [input_string[i:i+3] for i in range(0, len(input_string), 3)]
    
    # Rotate each chunk if it contains exactly three characters
    rotated_chunks = [(chunk[1:] + chunk[0]) if len(chunk) == 3 else chunk for chunk in chunks]
    
    # Join the rotated chunks back into a single string
    return ''.join(rotated_chunks)


def reverse_transform_string_cyclic(encoded_string: str):
    # Apply the transformation twice to decode the string
    return transform_string_cyclic(transform_string_cyclic(encoded_string))

# method name: encode_cyclic -> transform_string_cyclic
# method name: decode_cyclic -> reverse_transform_string_cyclic
# parameter name: s -> input_string, s -> encoded_string
# changed list comprehension for splitting string into groups/chunks
# used range with step in list comprehension for splitting
# kept the logic for rotating chunks but changed variable names
# added comments for clarity on each step