/* eslint-disable no-unused-vars */
/* DisplayMedia.jsx */
import React, { useEffect, useState } from 'react';
import { Button, Form, InputGroup, Table } from 'react-bootstrap'; // Use Button and Table components from React Bootstrap
import "../DisplayMedia.css";
import { listBranches } from '../services/BranchService'; // Assuming you have a separate service for Branches
import { listMedia } from '../services/MediaService';

const DisplayMedia = () => {
  const [media, setMedia] = useState([]);
  const [branches, setBranches] = useState([]);
  const [search, setSearch] = useState('');

  useEffect(() => {
    // Fetch Media data
    listMedia().then((response) => {
      console.log("Fetched Media Data:", response.data); // Log media data
      setMedia(response.data);
    }).catch(error => {
      console.error('Error fetching media:', error);
    });

    // Fetch Branch data (if needed for later use, like displaying branch name)
    listBranches().then((response) => {
      console.log("Fetched Branch Data:", response.data); // Log branch data
      setBranches(response.data);
    }).catch(error => {
      console.error('Error fetching branches:', error);
    });
  }, []);

  return (
    <div className='DisplayMedia'>
      <h1 className='mt-4 text-center'>Media Directory</h1>
      
      {/* Search bar */}
      <Form>
        <InputGroup className='my-3'>
          <Form.Control
            type="text"
            placeholder='Search Media by Title'
            onChange={(e) => setSearch(e.target.value)}
            value={search}
          />
        </InputGroup>
      </Form>

      {/* Media Table */}
      <Table responsive className="table-bordered table-striped">
        <thead>
          <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Year</th>
            <th>Branch ID</th>
          </tr>
        </thead>
        <tbody>
          {media.filter((mediaItem) => {
            return search.toLowerCase() === ''
              ? mediaItem
              : mediaItem.title.toLowerCase().includes(search.toLowerCase());
          }).map((mediaItem) => (
            <tr key={mediaItem.id}>
              <td>{mediaItem.title}</td>
              <td>{mediaItem.author}</td>
              <td>{mediaItem.year}</td>
              <td>{mediaItem.branch_id}</td>
            </tr>
          ))}
        </tbody>
      </Table>

      {/* Button to add media */}
      <div>
        <Button className="d-flex justify-content-center mt-4">Add Media</Button>
      </div>
    </div>
  );
};

export default DisplayMedia;
