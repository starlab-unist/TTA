def check_date_validity(date_str):
    try:
        cleaned_date = date_str.strip()
        parts = cleaned_date.split('-')
        month, day, year = map(int, parts)

        if not (1 <= month <= 12):
            return False

        if month in {1, 3, 5, 7, 8, 10, 12} and not (1 <= day <= 31):
            return False

        if month in {4, 6, 9, 11} and not (1 <= day <= 30):
            return False

        if month == 2 and not (1 <= day <= 29):
            return False

    except Exception:
        return False

    return True

# method name: valid_date -> check_date_validity
# parameter name: date -> date_str
# variable name: date -> cleaned_date, month, day, year -> directly assigned using map
# replaced list with set for month checks
# used direct comparison instead of separate conditions for day checks
# kept the exception handling but used a more general Exception class