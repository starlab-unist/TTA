from typing import List

def analyze_parentheses_depth(paren_sequence: str) -> List[int]:
    def calculate_max_nesting_level(substring):
        current_level = 0
        peak_level = 0
        for character in substring:
            if character == '(':
                current_level += 1
                peak_level = max(current_level, peak_level)
            elif character == ')':
                current_level -= 1

        return peak_level

    return [calculate_max_nesting_level(segment) for segment in paren_sequence.split() if segment]

# method name: parse_nested_parens -> analyze_parentheses_depth
# parameter name: paren_string -> paren_sequence
# inner function name: parse_paren_group -> calculate_max_nesting_level
# variable name: depth -> current_level, max_depth -> peak_level
# simplified split(' ') to split() which handles multiple spaces implicitly
# removed the explicit check `if x` as split() already filters out empty strings