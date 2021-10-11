import React, { useEffect, useState } from "react"
import axios from "axios"
import "./App.scss"
import {
  Container,
  Row,
  Col,
  ListGroup,
  ListGroupItem,
  Form,
} from "react-bootstrap"

const App = (props) => {
  const [countries, setCountries] = useState([])
  const [filtered, setFiltered] = useState([])
  const [search, setSearch] = useState("")

  const Getrepo = () => {
      const response = axios.get("http://localhost:8080/country/list")
      .then ((response) => { setCountries(response.data)});
      
  };
useEffect (() =>Getrepo(),[]);

  useEffect(() => {
    setFiltered(
      countries.filter((country) =>
        country.capital.toUpperCase().includes(search.toUpperCase()) || country.name.toUpperCase().includes(search.toUpperCase())
      )
    )
 
  }, [countries, search])
  const handleSearch = (event) => {
    setSearch(event.target.value)
  }

  return (
    <Container fluid className="bg-light">
      <h1 className="text-center text-primary p-5">Country Browser</h1>
      <Row>
        <Col md="5" className="py-5">
          <Form className="pb-5">
            <Form.Label>Find Country Or Capital</Form.Label>
            <Form.Control
              value={search}
              type="text"
              placeholder="Filter Countries Or Capital..."
              onChange={handleSearch}
            />
          </Form>
          <ListGroup>
            {filtered.map((country) => (
              <ListGroupItem
                action
                key={country.name}
              >
                <ListGroup.Item>{country.name}</ListGroup.Item>
                <ListGroup.Item>{country.capital}</ListGroup.Item>
                <ListGroup.Item>{country.region}</ListGroup.Item>
                <ListGroup.Item>{<th style={{width:150}}><img style= {{width:75, height:35}} src ={country.flag} alt=""></img></th>}</ListGroup.Item>

              </ListGroupItem>
            ))}
          </ListGroup>
        </Col>
        <Col md="9" className="py-2">
        </Col>
      </Row>
    </Container>
  )
}

export default App

