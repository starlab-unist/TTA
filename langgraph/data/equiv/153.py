def find_powerful_addon(base_class, addon_list):
    powerful_addon = addon_list[0]
    max_strength = sum(1 for char in addon_list[0] if char.isupper()) - sum(1 for char in addon_list[0] if char.islower())

    for addon in addon_list:
        current_strength = sum(1 for char in addon if char.isupper()) - sum(1 for char in addon if char.islower())
        if current_strength > max_strength:
            powerful_addon = addon
            max_strength = current_strength

    result = f"{base_class}.{powerful_addon}"
    return result

# method name: Strongest_Extension -> find_powerful_addon
# parameter name: class_name -> base_class, extensions -> addon_list
# variable name: strong -> powerful_addon, my_val -> max_strength, s -> addon, val -> current_strength
# replaced list comprehensions with generator expressions for sum calculation
# used f-string for constructing the final result string