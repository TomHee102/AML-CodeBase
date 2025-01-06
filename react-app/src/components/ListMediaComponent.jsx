/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from 'react'
import "../App.css";
import { InputGroup } from 'react-bootstrap'
import Form from 'react-bootstrap/Form'
import Modal from 'react-modal'
import { Button, Text, View } from 'react-native-web'
import { listMedia } from '../services/MediaService'
import { MdHeight } from 'react-icons/md';

const ListMediaComponent = () => {
    const customStyles = {
        content: {
            top: '50%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
      };

    // axois API call
    const [media, setMedia] = useState([])
    const [selected, setSelected] = useState([])
    const [isModalVisible, setModalVisible] = useState(false);

    const toggleModal = () => {
        setModalVisible(!isModalVisible);
    };

    useEffect(() => {
        listMedia().then((response) => {
            setMedia(response.data);
        }).catch(error => {
            console.error(error)
        })
        
    }, [])

    // search state
    const [search, setSearch] = useState('')

    const selectChange = value => {
        setSelected(value);
        console.log(value);
    }

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
                    if(item[key] != null)
                    {
                        return item[key].toString().toLowerCase().includes(valueToLower)
                    }
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
        <Form className='search'>
            <InputGroup className='my-3'>
                <Form.Control onChange={(e)=>handleChange(e.target.value)} placeholder='Search'/>
            </InputGroup>
        </Form>
        <div className='table-responsive'>
            <table className='table small'>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Category</th>
                        <th>Provider</th>
                        <th>Year</th>
                        <th>Branch</th>
                    </tr> 
                </thead>
                <tbody>
                    {
                        media.map(media =>
                            <tr onClick={(e) => selectChange(media)} key={media.id}>
                                <td>{media.title}</td>
                                <td>{media.author}</td>
                                <td>{media.category}</td>
                                <td>{media.publisher}</td>
                                <td>{media.year}</td>
                                <td>{media.branch}</td>
                            </tr>
                        )
                    }
                    {media.length === 0 && <span>No results found!</span>}
                </tbody>
            </table>
        </div>  
        <div className='mediaInfoContainer'>
            {
                (
                    <ul className='mediaInfo'>
                        <li>Title: {selected.title}</li>
                        <li>Author: {selected.author}</li>
                        <li>Category: {selected.category}</li>
                        <li>Publisher: {selected.publisher}</li>
                        <li>Branch: {selected.branch}</li>
                    </ul>
                )
            }
            <Button title='Borrow' onPress={toggleModal} size='lg' color='#58AAB9'/>
            <Modal
                style={customStyles}
                isOpen={isModalVisible}
                contentLabel="Example Modal">
                    <div className='popupText'>
                        <Text>You've successfully borrowed <b>{selected.title}!</b></Text>
                        <Button title='Close' onPress={toggleModal} size='lg' color='#58AAB9'/>
                    </div>
            </Modal>
        </div>
    </div>
  )
}

export default ListMediaComponent