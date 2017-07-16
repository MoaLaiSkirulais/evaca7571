RED='\033[0;31m'
NC='\033[0m' # No Color

printf "I ${RED}plazo.index${NC}\n"
curl -v http://172.22.97.51:8080/plazo/index

printf "I ${RED}plazo.edit${NC}\n"
curl -v http://172.22.97.51:8080/plazo/edit

printf "I ${RED}plazo.save${NC}\n"
curl -v http://172.22.97.51:8080/plazo/save

printf "I ${RED}plazo.create${NC}\n"
curl -v http://172.22.97.51:8080/plazo/create

