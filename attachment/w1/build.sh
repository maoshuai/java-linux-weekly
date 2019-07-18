PROJECT_DIR=/home/maoshuai/javaLinux/w1

# clean target directory
mkdir -p $PROJECT_DIR/target # incase no target
rm -rf $PROJECT_DIR/target/*

# prepare arg files
find $PROJECT_DIR/src -name "*.java">$PROJECT_DIR/target/javaFiles.txt
echo "-d $PROJECT_DIR/target" >$PROJECT_DIR/target/javaOptions.txt

# compile
javac -cp "$PROJECT_DIR/lib/*" @$PROJECT_DIR/target/javaOptions.txt @$PROJECT_DIR/target/javaFiles.txt

# copy resources to target
cp -rf $PROJECT_DIR/resources/* $PROJECT_DIR/target

# clean temp files
rm -rf $PROJECT_DIR/target/javaOptions.txt $PROJECT_DIR/target/javaFiles.txt

