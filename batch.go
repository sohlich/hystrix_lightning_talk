package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"sync"
)

func main() {
	log.Printf("Application %s starting.", "Hystrix batch test")

	wg := &sync.WaitGroup{}
	for i := 0; i < 100; i++ {
		wg.Add(1)
		go func(id int) {
			defer wg.Done()
			resp, err := http.Get(fmt.Sprintf("http://localhost:8080/api/batch/%d", id))
			if err != nil {
				log.Println(err.Error())
			} else {
				out, _ := ioutil.ReadAll(resp.Body)
				log.Printf("%s : %s", resp.StatusCode, string(out))
			}
		}(i)
	}

	wg.Wait()
}
