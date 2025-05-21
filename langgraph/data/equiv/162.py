import hashlib

def convert_text_to_hash(input_string):
    if not input_string:
        return None
    encoded_string = input_string.encode('ascii')
    md5_hash = hashlib.md5(encoded_string).hexdigest()
    return md5_hash

# method name: string_to_md5 -> convert_text_to_hash
# parameter name: text -> input_string
# moved the import statement outside the function
# replaced the conditional expression with an if statement for clarity
# split the encoding and hashing steps for better readability