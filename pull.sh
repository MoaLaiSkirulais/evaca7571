git config --global credential.helper cache
git config credential.helper store
git pull origin aviso_centric

# /etc/init.d/lighttpd stop
# pkill java
# sudo sysctl -w vm.drop_caches=3

# ( nohup grails run-app --port=80 --non-interactive 2>&1 > /dev/null & )
 