__author__ = 'xuwei19'

from urllib import urlopen
import re
import fileinput
import sys

# def get_url_value(first_url,depth):
# first_url=str(sys.args[1])
# depth=int(sys.args[2])
url_value_file_path_jieya_directory = str(sys.argv[1])
first_url = str(sys.argv[2])
depth = int(sys.argv[3])
url_value_file_path_directory = url_value_file_path_jieya_directory + "\\result\\"


def writeToFileFromUrl(url, filename):
    try:
        webpage = urlopen(url)
        text = webpage.read()
        pattern_a_href = "<a href=\"(.+?)\".*>([^<]+)</a>"
        pattern_option_value = "<option value=\"(.+?)\".*>(.+)</option>"
        url_value_list = re.findall(pattern_option_value, text, re.IGNORECASE)
        url_value_file_path = url_value_file_path_directory + filename
        f = open(url_value_file_path, "a")
        for e in url_value_list:
            url = e[0]
            value = e[1]
            f.write(url)
            f.write("|")
            f.write(value)
            f.write("\n")
        f.close()

        url_value_list = re.findall(pattern_a_href, text, re.IGNORECASE)
        f = open(url_value_file_path, "a")
        for e in url_value_list:
            url = e[0]
            value = e[1]
            f.write(url)
            f.write("|")
            f.write(value)
            f.write("\n")
        f.close()
    # washData(filename)
    except (IOError, Exception), e:
        error_file_path = url_value_file_path_directory + "error.txt"
        f = open(error_file_path, "a")
        old_out = sys.stdout
        sys.stdout = f
        print e
        sys.stdout = old_out
        f.close()
        raise


# def washData(filename):
# url_value_file_path=url_value_file_path_directory+filename
# f=open(url_value_file_path,"w+")
#    pattern="http://[^a-zA-Z0-9]+\.com"
#    f.write(re.sub(pattern,"",f.read()))
#    f.close()

def get_results(first_url, depth):
    writeToFileFromUrl(first_url, "result0.txt")
    if depth == 1:
        return

    for i in range((depth - 1)):
        for line in fileinput.input(url_value_file_path_directory + ("result" + str(i) + ".txt")):
            url = line.split("|")[0]
            #            print url
            try:
                writeToFileFromUrl(url, "result" + str(i + 1) + ".txt")
            except:
                continue


get_results(first_url, depth)




