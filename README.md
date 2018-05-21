#atlas-generator

A simple program to convert OSM PBF's to Atlas files.  
This program uses [Atlas](https://github.com/osmlab/atlas)'s built in converter. 

## Usage

The program uses Gradle, and operates using the task `pbfToAtlas`.  

It takes two arguments:  
`-Pinout`: input file path  
`-Poutput`: output file path

`Gradle pbfToAtlas -Pinput=inputFilePath -Poutput=outputFilePath`

If running from a location other than the root of this program use `-p` to define the root.  
Relative paths of `inputFilePath` and `outputFilePath` are always from the project root.  

### Size Constraint

This program suffers from the same PBF size constraints as all implementations of Atlas.  
You will only be able to run files that can be processed in your machines memory.  
This is the same as AtlasChecks.

##Python Example

A simple python script to loop through a directory of PBF's and convert them to Atlas files. 

```python
import os

for file in os.listdir("pbfs"):
	print file
	os.system("gradle pbfToAtlas -p ../pbfToAtlas -PcmdArgs=../pbfToAtlas_py_test/pbfs/{0},../pbfToAtlas_py_test/atlas/{1}.atlas".format(file,file.split('.')[0]))
```