@echo off

set /p commit_message=Enter commit message:
call cd.. && call cd.. && call del /S *.class && call git add . && git commit -m "add %commit_message% solution"