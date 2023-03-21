import csv
import sys

# TODO: read(csv_file)
def read(csv_file):
    data = []
    with open(csv_file, 'r') as f:
        file = csv.reader(f)
        for line in file:
            data.append(line)
    return data

# TODO: filter_data(user_input, data)
def filter_data(user_input, data):
    filtered_data = []
    data.pop(0)
    for row in data:
        for i in row:
            if i == user_input:
                filtered_data.append(row)
    
    return filtered_data
# TODO: calc_averages(filtered_data)
def calc_averages(filtered_data):
    ic = []
    l = []
    dp = []

    for i in filtered_data:
        ic.append(int(i[7]))
        l.append(int(i[8]))
        dp.append(int(i[9]))
    
    avgIc = sum(ic) / len(ic)
    avgLongevity = sum(l) / len(l)
    avgDaysParalyzed = sum(dp) / len(dp)

    return avgIc, avgLongevity, avgDaysParalyzed

    
# TODO: calc_minimums(filtered_data)
def calc_minimums(filtered_data):
    minIc = []
    minLongevity = []
    minDaysParalyzed = []
    for i in filtered_data:
        minIc.append(int(i[7]))
        minLongevity.append(int(i[8]))
        minDaysParalyzed.append(int(i[9]))
    return min(minIc), min(minLongevity), min(minDaysParalyzed)
    
# TODO: calc_maximums(filtered_data)
def calc_maximums(filtered_data):
    maxIc = []
    maxLongevity = []
    maxDaysParalyzed = []
    for i in filtered_data:
        maxIc.append(int(i[7]))
        maxLongevity.append(int(i[8]))
        maxDaysParalyzed.append(int(i[9]))
    return max(maxIc), max(maxLongevity), max(maxDaysParalyzed)



# TODO: print_stats(input, stat_type, stats)

def print_stats(input, stat_type, stats):
    statHeader = "{} for ".format(stat_type) + input + " bees:"
    ic = "{} Imidacloprid Concentration: {:.2f}".format(stat_type, stats[0])
    longevity = "{} Longevity: {:.2f}".format(stat_type, stats[1])
    daysParalyzed  = "{} Days Paralyzed: {:.2f}".format(stat_type, stats[2])
    
    finalString = statHeader + "\n" + ic + "\n" + longevity + "\n" + daysParalyzed 
    return finalString
    
    

print("blue")
# TODO: run(data)

def run(data):

    userInput = input("Enter the species/genus or the sociality of bee you would like information about:")
    print("\n" + print_stats(userInput, "Average", calc_averages(filter_data(userInput.upper(), data))))
    print("\n" + print_stats(userInput, "Minimum", calc_minimums(filter_data(userInput.upper(), data))))
    print("\n" + print_stats(userInput, "Maximum", calc_maximums(filter_data(userInput.upper(), data))))
    



    check = input("Would you like to see more data? (Y/N)")

    if check.upper() == "Y":
        return True
    else: 
        return False
    

def main():
    if len(sys.argv) != 2:
        print('Invalid arguments given')
        return
    data = read(sys.argv[1])
    while run(data):
        continue
        

if __name__ == '__main__':
    main()