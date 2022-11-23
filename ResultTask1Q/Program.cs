// See https://aka.ms/new-console-template for more information
string[] lines = {"hello", "2", "world", ":-)"};
string[] result;
int j = 0;

for(int i = 0; i < lines.Length; i++)
{
    if(lines[i].Length<=3)
    {
        j++;
    }
}

result = new string[j];
int k = 0;
for(int n = 0; n<lines.Length; n++)
{
    if(lines[n].Length<=3)
    {
        result[k] = lines[n];
        k++;
    }
}
