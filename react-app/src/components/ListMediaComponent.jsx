/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from 'react'
import "../App.css";
import { InputGroup } from 'react-bootstrap'
import Form from 'react-bootstrap/Form'
import { Button } from 'react-native-web'
import { listMedia } from '../services/MediaService'

const ListMediaComponent = () => {

    // axois API call
    const [media, setMedia] = useState([])

    useEffect(() => {
        listMedia().then((response) => {
            setMedia(response.data);
        }).catch(error => {
            console.error(error)
        })
        
    }, [])

    // search state
    const [search, setSearch] = useState('')

    const handleChange = value => {
        setSearch(value);
        filterData(value);
    }

    
    const filterData = value => {
        const valueToLower = value.toLowerCase().trim();

        if(valueToLower)
        {
            const filteredData = media.filter(item => {
                return Object.keys(item).some(key => {
                    return item[key].toString().toLowerCase().includes(valueToLower)
                })
            });
            setMedia(filteredData)
        }
        else
        {
            listMedia().then((response) => {
                setMedia(response.data)
            })
        }
    }

  return (
    <div className='container'>
        <h1>Media Directory</h1>
        <Form>
            <InputGroup className='my-3'>
                <Form.Control onChange={(e)=>handleChange(e.target.value)} placeholder='Search'/>
            </InputGroup>
        </Form>
        <table class='rounded' className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Year</th>
                    <th>Branch</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {
                    media.map(media =>
                        <tr key={media.id}>
                            <td>{media.title}</td>
                            <td>{media.author}</td>
                            <td>{media.year}</td>
                            <td>{media.branch}</td>
                            <td>
                                <Button title='Borrow'onPress={() => console.log(media.id)}/>
                            </td>
                        </tr>
                    )
                }
                {media.length === 0 && <span>Not results found!</span>}
            </tbody>
        </table>
    </div>
  )
}

export default ListMediaComponent