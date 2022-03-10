
for file in test-files/*.md;
do
  echo "file name: $file"
  java MarkdownParse $file
done
