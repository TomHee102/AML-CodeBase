/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from 'react'
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
    console.log(search)

  return (
    <div className='container'>
        <h1 className='mt-4'>Media Directory</h1>
        <Form>
            <InputGroup className='my-3'>
                <Form.Control onChange={(e)=>setSearch(e.target.value)} placeholder='Search'/>
            </InputGroup>
        </Form>
        <table className='table table-striped table-bordered'>
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
                    media.filter((media) => {
                        return search.toLowerCase() === '' 
                        ? media 
                        : media.title.toLowerCase().includes(search);
                    }).map(media =>
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
            </tbody>
        </table>
    </div>
  )
}

export default ListMediaComponent