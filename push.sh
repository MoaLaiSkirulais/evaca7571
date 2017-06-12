git config --global credential.helper cache
git config credential.helper store
git add -A
git commit -m "bash sync"
git push origin master
