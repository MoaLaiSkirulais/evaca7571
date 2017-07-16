RED='\033[0;31m'
NC='\033[0m' # No Color

printf "I ${RED}categoria.index${NC}\n"
curl -v http://172.22.97.51:8080/categoria/index

printf "I ${RED}categoria.edit${NC}\n"
curl -v http://172.22.97.51:8080/categoria/edit

printf "I ${RED}categoria.save${NC}\n"
curl -v http://172.22.97.51:8080/categoria/save

printf "I ${RED}categoria.create${NC}\n"
curl -v http://172.22.97.51:8080/categoria/create

