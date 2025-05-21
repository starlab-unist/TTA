def check_valid_date(d):
    try:
        d = d.strip()
        m, d, y = map(int, d.split('-'))
        
        if not (1 <= m <= 12):
            return False
        
        if m in {1, 3, 5, 7, 8, 10, 12} and not (1 <= d <= 31):
            return False
        
        if m in {4, 6, 9, 11} and not (1 <= d <= 30):
            return False
        
        if m == 2 and not (1 <= d <= 29):
            return False
    
    except ValueError:
        return False

    return True

# method name: valid_date -> check_valid_date
# parameter name: date -> d
# variable names: month -> m, day -> d, year -> y
# replaced multiple if conditions with a single condition per month check
# used set instead of list for months with 31 days and 30 days for slight performance improvement
# replaced generic 'except:' with specific 'except ValueError:' to catch only expected exceptions