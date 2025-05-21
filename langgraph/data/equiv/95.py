def evaluate_dictionary_keys_casing(input_dict):
    if not input_dict:
        return False

    casing_state = None
    for key in input_dict:
        if not isinstance(key, str):
            return False

        if casing_state is None:
            if key.isupper():
                casing_state = 'UPPER'
            elif key.islower():
                casing_state = 'LOWER'
            else:
                return False
        else:
            if (casing_state == 'UPPER' and not key.isupper()) or (casing_state == 'LOWER' and not key.islower()):
                return False

    return casing_state in ['UPPER', 'LOWER']

# method name: check_dict_case -> evaluate_dictionary_keys_casing
# parameter name: dict -> input_dict
# variable name: state -> casing_state
# replaced len(dict.keys()) == 0 with not input_dict for checking empty dictionary
# used a more direct return False when encountering non-string keys
# simplified the state transition logic and removed unnecessary breaks
# used a set membership test for the final return condition