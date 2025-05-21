def transform_cyclic_string(input_string: str):
    """
    Returns encoded string by cycling groups of three characters.
    """
    # Divide the string into chunks of three characters
    chunks = [input_string[i:i+3] for i in range(0, len(input_string), 3)]
    
    # Rotate each chunk if it contains exactly three characters
    rotated_chunks = [(chunk[1:] + chunk[0]) if len(chunk) == 3 else chunk for chunk in chunks]
    
    # Join all chunks back into a single string
    return ''.join(rotated_chunks)


def reverse_cyclic_transformation(encoded_string: str):
    # Apply the transformation twice to decode the string
    return transform_cyclic_string(transform_cyclic_string(encoded_string))

# method name: encode_cyclic -> transform_cyclic_string
# method name: decode_cyclic -> reverse_cyclic_transformation
# parameter name: s -> input_string, s -> encoded_string
# variable name: groups -> chunks, groups -> rotated_chunks
# changed list comprehension syntax for splitting and rotating
# used range with step in list comprehension for splitting
# added comments for clarity on each step